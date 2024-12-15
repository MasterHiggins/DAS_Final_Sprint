@SpringBootTest
public class BinarySearchTreeServiceTest {
    @Autowired
    private BinarySearchTreeService service;

    @Test
    public void testCreateTree() {
        List<Integer> numbers = Arrays.asList(5, 3, 7, 2, 4, 6, 8);
        BinarySearchTreeNode root = service.createTree(numbers);
        assertNotNull(root);
    }
}
