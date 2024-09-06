package org.example.cefomar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.Normalizer;
import java.util.List;
import java.util.function.Consumer;

@Data
public class FilesOutputFormation implements AutoCloseable{
    private OutputStream outputStream;

    public FilesOutputFormation(OutputStream os){
        this.outputStream= os;
    }

    public void writeFields(List<Formation> formations){
        formations.stream()
                .map(this::formationToBytes)
                .forEach(consumerAddedFormations());
    }
    private Consumer<byte[]> consumerAddedFormations(){
        return bytes -> {
            try {
                outputStream.write(bytes);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
    private byte[] formationToBytes(Formation formation){
        byte[] bytesFormation= null;

        try (ByteArrayOutputStream bos= new ByteArrayOutputStream();
             DataOutputStream dataOutputStream= new DataOutputStream(bos);
             ) {

            dataOutputStream.writeUTF(formation.getName());
            dataOutputStream.writeUTF(formation.getRef());
            dataOutputStream.writeUTF(formation.getCoast().toString());
            dataOutputStream.flush();

            dataOutputStream.writeInt(formation.getDuration());

            formation.getStudents()
                    .forEach(consumerStudent(dataOutputStream));

            bos.flush();

            bytesFormation= bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bytesFormation;
    }

    private static Consumer<Student> consumerStudent(DataOutputStream dataOutputStream) {
        return student -> {
            try {
                dataOutputStream.writeUTF(student.getName());
                dataOutputStream.writeUTF(student.getNumber());
                dataOutputStream.flush();

                long timeStamp= student.getDateOfBirth().getTime();

                dataOutputStream.writeLong(timeStamp);
                dataOutputStream.flush();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    @Override
    public void close() throws Exception {
        this.outputStream.close();
    }
}
