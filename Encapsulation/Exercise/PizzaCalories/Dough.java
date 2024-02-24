package PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy") || bakingTechnique.equals("Homemade")) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public double calculateCalories() {
        double flourTypeCoefficient = getFlourTypeCoefficient(this.flourType);
        double bakingTechniqueCoefficient = getBakingTechniqueCoefficient(this.bakingTechnique);
        return (2 * this.weight) * flourTypeCoefficient * bakingTechniqueCoefficient;
    }

    private double getBakingTechniqueCoefficient(String bakingTechnique) {
       switch (bakingTechnique) {
            case "Crispy":
              return 0.9;

            case "Chewy" :
                return 1.1;
            case "Homemade" :
                return 1.0;

        }
        return 0;
    }

    private double getFlourTypeCoefficient(String flourType) {
        double flourTypeCoefficient = 0;
        if (flourType.equals("White")) {
            flourTypeCoefficient = 1.5;
        } else if (flourType.equals("Wholegrain")) {
            flourTypeCoefficient = 1.0;
        }
        return flourTypeCoefficient;
    }
}





