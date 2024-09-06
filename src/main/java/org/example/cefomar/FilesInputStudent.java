package org.example.cefomar;

import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

@Data
public class FilesInputStudent implements AutoCloseable{
    private static final Student EOF= new Student("EOF", null, null, null);
    private InputStream inputStream;
    //private Function<ByteArrayInputStream, Stream<Student>> byteToStudent= this::byteToStudent;

    public FilesInputStudent(InputStream is){
        this.inputStream= is;
    }

    public List<Student> readFields(){
        //List<Student> students= new ArrayList<>();
        try (BufferedInputStream buffered= new BufferedInputStream(inputStream);){

            byte[] bytes= buffered.readAllBytes();
            ByteArrayInputStream byteArray= new ByteArrayInputStream(bytes);

            return Stream.generate(() -> byteToStudent(byteArray))
                    //.map(stream -> stream)
                    .takeWhile(this::isEndOfStream)
                    .toList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isEndOfStream(Student student){
        return !student.equals(EOF);
    }
    private Student byteToStudent(ByteArrayInputStream byteArray){
        Student student= null;

        try (DataInputStream dataInputStream= new DataInputStream(byteArray);) {
            student= Student.builder()
                    .name(dataInputStream.readUTF())
                    .formation(dataInputStream.readUTF())
                    .number(dataInputStream.readUTF())
                    .dateOfBirth(new Date(dataInputStream.readLong()))
                    .build();

            return student;

        } catch (EOFException e){
            return EOF;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        inputStream.close();
    }
}
