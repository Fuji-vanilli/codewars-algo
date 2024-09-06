package org.example.kyu5;

import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

@Data
public class PersonInputStream implements AutoCloseable{
    private final static Person EOF= new Person("EOF", null, 0);
    private InputStream inputStream;
    private Function<ByteArrayInputStream, Stream<Person>> bytesToPerson= this::bytesToPerson;

    public PersonInputStream(InputStream is){
        this.inputStream= is;
    }

    public List<Person> readFields(){

        try(BufferedInputStream buffer= new BufferedInputStream(inputStream);) {
            byte[] bytes= buffer.readAllBytes();

            ByteArrayInputStream bis= new ByteArrayInputStream(bytes);

            return Stream.generate(() -> bytesToPerson(bis))
                    .flatMap(stream -> stream)
                    .takeWhile(this::isEndOfStream)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isEndOfStream(Person person) {
        return !person.equals(EOF);
    }

    private Stream<Person> bytesToPerson(ByteArrayInputStream byteArray) {
        try(DataInputStream dis= new DataInputStream(byteArray);) {

            String name= dis.readUTF();
            String city= dis.readUTF();

            int age= dis.readInt();

            return Stream.of(new Person(name, city, age));
        } catch (EOFException e) {
            return Stream.of(EOF);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }
}
