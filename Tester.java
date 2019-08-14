import org.junit.*;

public class Tester {
    private Array<Integer> arr, arr2;

    @Before
    public void init(){
        arr = new AdvancedArray(5);
        arr2 = new AdvancedArray();
    }

    @Test()
    public void defaultSizeCreateTest() {
        Assert.assertArrayEquals(arr2.getArray(), new Integer[]{});
    }

    @Test()
    public void addTest(){
        arr2.add(1);
        Assert.assertArrayEquals(arr2.getArray(), new Integer[]{1});
    }

    @Test()
    public void addTest1(){
        arr.add(1);
        arr.add(5);
        arr.add(3);
        arr.add(-1);
        arr.add(0);
        arr.add(4);
        Assert.assertTrue(arr.addByIndex(5, 7));
        Assert.assertFalse(arr.addByIndex(10, 7));
        Assert.assertArrayEquals(arr.getArray(), new Integer[]{1, 5, 3, -1, 0, 7});
        Assert.assertEquals(arr.getSize(), 6);
    }

    @Test()
    public void removeByIndexTest(){
        arr.add(1);
        arr.add(5);
        arr.add(3);
        arr.add(-1);
        arr.add(0);
        arr.add(4);
        Assert.assertTrue(arr.removeByIndex(3));
        Assert.assertTrue(arr.removeByIndex(4));
        Assert.assertTrue(arr.removeByIndex(0));
        Assert.assertFalse(arr.removeByIndex(5));
        Assert.assertArrayEquals(arr.getArray(), new Integer[]{5, 3, 0});
        Assert.assertEquals(arr.getSize(), 3);
    }

    @Test()
    public void removeTest(){
        arr.add(1);
        arr.add(5);
        arr.add(3);
        arr.add(-1);
        arr.add(0);
        arr.add(4);
        Assert.assertTrue(arr.remove(-1));
        Assert.assertFalse(arr.remove(99));
        Assert.assertArrayEquals(arr.getArray(), new Integer[]{1, 5, 3, 0, 4});
        Assert.assertEquals(arr.getSize(), 5);
    }

    @Test()
    public void insertTest(){
        arr.add(1);
        arr.add(5);
        Assert.assertTrue(arr.insert(1, 99));
        Assert.assertFalse(arr.insert(3, 999));
        Assert.assertArrayEquals(arr.getArray(), new Integer[]{1, 99, 5});
    }

    @Test()
    public void getTest(){
        arr.add(1);
        Assert.assertEquals(arr.get(0), new Integer(1));
    }

    @Test()
    public void containsTest(){
        arr.add(1);
        arr.add(5);
        Assert.assertTrue(arr.insert(1, 99));
        Assert.assertTrue(arr.contains(5));
        Assert.assertFalse(arr.contains(2));
    }

    @Test()
    public void sortBubbleTest(){
        arr.add(3);
        arr.add(-1);
        arr.add(3);
        arr.add(2);
        arr.add(4);
        arr.sort(SortingMethod.BUBBLE);
        Assert.assertArrayEquals(arr.getArray(), new Integer[]{-1, 2, 3, 3, 4});
    }

   @Test()
    public void sortInsertTest(){
        arr.add(3);
        arr.add(-1);
        arr.add(3);
        arr.add(2);
        arr.add(4);
        arr.sort(SortingMethod.INSERT);
        Assert.assertArrayEquals(arr.getArray(), new Integer[]{-1, 2, 3, 3, 4});
    }

    @Test()
    public void sortSelectTest(){
        arr.add(3);
        arr.add(-1);
        arr.add(3);
        arr.add(2);
        arr.add(4);
        arr.sort(SortingMethod.SELECT);
        Assert.assertArrayEquals(arr.getArray(), new Integer[]{-1, 2, 3, 3, 4});
    }
}
