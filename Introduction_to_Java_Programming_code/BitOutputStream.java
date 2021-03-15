import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class BitOutputStream implements AutoCloseable {
  private FileOutputStream output;
  private int bits;
  private int position;

  public BitOutputStream(File file) throws IOException {
    output = new FileOutputStream(file);
  }

  public void writeBit(char bit) throws IOException {
    bits = bits << 1;
    if (bit == '1') {
      bits = bits | 1;
    }

    position++;

    if (position == 8) {
      output.write((byte)bits);
      bits = 0;
      position = 0;
    }
  }

  public void writeBit(String bit) throws IOException {
    for (int i = 0; i < bit.length(); i++) {
      char c = bit.charAt(i);
      writeBit(c);
    }
  }

  public void close() throws IOException {
    if (bits != 0) {
      bits = bits << (8 - position);
      output.write((byte)bits);
    }
    output.close();
  }
}
