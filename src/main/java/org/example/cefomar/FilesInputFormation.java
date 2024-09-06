package org.example.cefomar;

import lombok.Data;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Data
public class FilesInputFormation implements AutoCloseable{
    public final static Formation EOF= Formation.builder()
            .name("EOF")
            .duration(null)
            .coast(null)
            .students(null)
            .build();
    private InputStream inputStream;

    public FilesInputFormation(InputStream inputStream){
        this.inputStream= inputStream;
    }

    public List<Formation> readFields(){

        try (BufferedInputStream buffered= new BufferedInputStream(inputStream)) {
            byte[] bytesFormation= buffered.readAllBytes();
            ByteArrayInputStream byteArrayInputStream= new ByteArrayInputStream(bytesFormation);

            return Stream.generate(()-> toFormationStream(byteArrayInputStream))
                    .takeWhile(this::isEndOfStream)
                    .toList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Formation toFormationStream(ByteArrayInputStream byteArray){

        try ( DataInputStream dataInputStream= new DataInputStream(byteArray);) {
            Formation formation= Formation.builder()
                    .name(dataInputStream.readUTF())
                    .ref(dataInputStream.readUTF())
                    .coast(dataInputStream.readLong())
                    .duration(dataInputStream.readInt())
                    .students(new ArrayList<>())
                    .build();

            int numberStudent= dataInputStream.readInt();
/*
            for(int i= 0; i< numberStudent; i++){
                Student student= Student.builder()
                        .name(dataInputStream.readUTF())
                        .number(dataInputStream.readUTF())
                        .dateOfBirth(new Date(dataInputStream.readLong()))
                        .build();
                formation.getStudents().add(student);
            }
*/
            return formation;
        } catch (EOFException e){
            return EOF;
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isEndOfStream(Formation formation){
        return !Objects.equals(formation, EOF);
    }
    @Override
    public void close() throws Exception {
        this.inputStream.close();
    }
}
