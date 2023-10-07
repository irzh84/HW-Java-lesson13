public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        boolean result = false;
        for (String subtask : subtasks) {
            if (subtask.contains(query)) {
                result = true;
            }
        }
        return result;
    }

}


