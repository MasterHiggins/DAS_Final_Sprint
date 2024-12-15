public class TreeData {import jakarta.persistence.*;
    import java.util.List;

    @Entity
    public class TreeData {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ElementCollection
        private List<Integer> inputNumbers;

        @Lob
        private String treeStructureJson;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public List<Integer> getInputNumbers() {
            return inputNumbers;
        }

        public void setInputNumbers(List<Integer> inputNumbers) {
            this.inputNumbers = inputNumbers;
        }

        public String getTreeStructureJson() {
            return treeStructureJson;
        }

        public void setTreeStructureJson(String treeStructureJson) {
            this.treeStructureJson = treeStructureJson;
        }
    }

    }
