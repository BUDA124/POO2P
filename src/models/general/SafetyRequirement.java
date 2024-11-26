package models.general;

public class SafetyRequirement {
    private String id;
    private String description;
    private boolean isRequired;
    private boolean isCompleted;

    public SafetyRequirement(String description, boolean isRequired) {
        this.id = java.util.UUID.randomUUID().toString();
        this.description = description;
        this.isRequired = isRequired;
        this.isCompleted = false;
    }

    // Getters y setters
    public String getId() { return id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isRequired() { return isRequired; }
    public void setRequired(boolean required) { isRequired = required; }
    public boolean isCompleted() { return isCompleted; }
    public void setCompleted(boolean completed) { isCompleted = completed; }
}