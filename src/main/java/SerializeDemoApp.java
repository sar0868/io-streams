import java.io.Serializable;

public class SerializeDemoApp {
    private static class Cat implements Serializable {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {


    }
}
