package org.example.cefomar;

import lombok.Data;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.function.Consumer;

@Data
public class FilesOutputStudent implements AutoCloseable {
    private OutputStream outputStream;

    public FilesOutputStudent(OutputStream o){
        this.outputStream= o;
    }

    public void writeFields(List<Student> students){
        students.stream()
                .map(this::studentToBytes)
                .forEach(getConsumer());
    }

    private Consumer<byte[]> getConsumer() {
        return bytes -> {
            try {
                outputStream.write(bytes);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    private byte[] studentToBytes(Student student){
        byte[] byteStudent= null;

        try(ByteArrayOutputStream bos= new ByteArrayOutputStream();
            DataOutputStream dos= new DataOutputStream(bos);) {

            long timeStamp= student.getDateOfBirth().getTime();

            dos.writeUTF(student.getName());
            dos.writeUTF(student.getFormation());
            dos.writeUTF(student.getNumber());

            dos.flush();

            dos.writeLong(timeStamp);

            dos.flush();;
            bos.flush();

            byteStudent= bos.toByteArray();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return byteStudent;
    }

    @Override
    public void close() throws Exception {
        outputStream.close();
    }
}
