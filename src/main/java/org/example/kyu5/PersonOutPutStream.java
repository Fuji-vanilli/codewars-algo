package org.example.kyu5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.util.List;
import java.util.function.Consumer;

@Data
@NoArgsConstructor
public class PersonOutPutStream implements AutoCloseable{
    private OutputStream os;

    public PersonOutPutStream(OutputStream outputStream){
        this.os= outputStream;
    }
    public void writeFields(List<Person> persons){
        persons.stream()
                .map(this::personToBytes)
                .forEach(getConsumerStream());
                
    }
    private Consumer<byte[]> getConsumerStream() {
        return p-> {
            try {
                this.os.write(p);
            } catch (IOException e) {
                throw new RuntimeException("error to write byte on the stream");
            }
        };
    }

    public byte[] personToBytes(Person person){
        byte[] bytePerson= null;

        try(ByteArrayOutputStream bos= new ByteArrayOutputStream();
            DataOutputStream dos= new DataOutputStream(bos);) {

            //write String on the stream flux

            dos.writeUTF(person.getName());
            dos.writeUTF(person.getCity());

            dos.flush();

            //write int on the stream flux
            dos.writeInt(person.getAge());

            dos.flush();
            bos.flush();

            bytePerson= bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("error to write a byte on the stream array");
        }
        return bytePerson;
    }

    @Override
    public void close() throws IOException {
        os.close();
    }
}
