package Sprint.Chris.service;

import Sprint.Chris.model.BinarySearchTreeNode;
import Sprint.Chris.model.TreeData;
import Sprint.Chris.repository.TreeDataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BinarySearchTreeService {
    private final TreeDataRepository repository;
    private final ObjectMapper objectMapper;

    public BinarySearchTreeService(TreeDataRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    public BinarySearchTreeNode createTree(List<Integer> numbers) {
        BinarySearchTreeNode root = null;
        for (int number : numbers) {
            root = insertIntoTree(root, number);
        }
        return root;
    }

    private BinarySearchTreeNode insertIntoTree(BinarySearchTreeNode root, int value) {
        if (root == null) return new BinarySearchTreeNode(value);
        if (value < root.getValue()) root.setLeft(insertIntoTree(root.getLeft(), value));
        else root.setRight(insertIntoTree(root.getRight(), value));
        return root;
    }

    public void saveTreeData(List<Integer> numbers, BinarySearchTreeNode root) throws Exception {
        TreeData treeData = new TreeData();
        treeData.setInputNumbers(numbers);
        treeData.setTreeStructureJson(objectMapper.writeValueAsString(root));
        repository.save(treeData);
    }

    public List<TreeData> getPreviousTrees() {
        return repository.findAll();
    }
}
