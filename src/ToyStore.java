import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToyStore {
    private List<Toy> toys;

    public ToyStore() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyWeight(int toyId, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public Toy selectPrizeToy() {

        double totalWeight = 0;

        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        double randomWeight = Math.random() * totalWeight;

        double currentWeight = 0;

        for (Toy toy : toys) {

            currentWeight += toy.getWeight();

            if (randomWeight <= currentWeight) {
                toy.setQuantity(toy.getQuantity() - 1);
                toys.remove(toy);
                return toy;
            }
        }

        return null;
    }

    public void savePrizeToyToFile(Toy toy, String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(toy.getName() + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }
}
