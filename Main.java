import java.util.*;
class CareerRecommendation {
    String careerPath;
    List<String> requiredSkills;
    CareerRecommendation(String careerPath, List<String> requiredSkills) {
        this.careerPath = careerPath;
        this.requiredSkills = requiredSkills;
    }
    String getCareerPath() {
        
        return careerPath;
    }
    List<String> getRequiredSkills() {
        
        return requiredSkills;
    }
}
class Main {
    static final List<CareerRecommendation> careerOptions = new ArrayList<>();
    static {
        careerOptions.add(new CareerRecommendation("Software Developer", Arrays.asList("Java", "Problem Solving", "Teamwork")));
        careerOptions.add(new CareerRecommendation("Data Scientist", Arrays.asList("Statistics", "Python", "Machine Learning")));
        careerOptions.add(new CareerRecommendation("Graphic Designer", Arrays.asList("Creativity", "Adobe Suite", "Communication")));
        careerOptions.add(new CareerRecommendation("Project Manager", Arrays.asList("Leadership", "Communication", "Time Management")));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the AI-Enhanced Career Guidance System!");
        System.out.print("Please enter your name: ");
        String name = sc.nextLine();
        System.out.print("What are your main skills? (comma-separated): ");
        String skillsInput = sc.nextLine();
        List<String> userSkills = Arrays.asList(skillsInput.split(",\s*"));
        System.out.print("What are your career aspirations? (comma-separated): ");
        String aspirationsInput = sc.nextLine();
        List<String> userAspirations = Arrays.asList(aspirationsInput.split(",\s*"));
        System.out.println("Thank you, " + name + ". Based on your skills and aspirations, here are some career recommendations:");
        List<CareerRecommendation> recommendations = getCareerRecommendations(userSkills, userAspirations);
        if (recommendations.isEmpty()) {
            
            System.out.println("No suitable career paths found based on your input.");
        } else {
            
            for (CareerRecommendation recommendation : recommendations) {
                
                System.out.println("Career Path: " + recommendation.getCareerPath());
                System.out.println("Required Skills: " + String.join(", ", recommendation.getRequiredSkills()));
                System.out.println();
            }
        }
            sc.close();
    }
    static List<CareerRecommendation> getCareerRecommendations(List<String> userSkills, List<String> userAspirations) {
        List<CareerRecommendation> matchedCareers = new ArrayList<>();
        for (CareerRecommendation option : careerOptions) {
            for (String skill : option.getRequiredSkills()) {
                if (userSkills.contains(skill)) {
                    matchedCareers.add(option);
                    break; 
                }
            }
        }
                return matchedCareers;
    }
}

