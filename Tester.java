import org.junit.*;

public class Tester {
    private Array<Integer> arr;

    @Before
    public void init(){
        arr = new AdvancedArray(5);
    }

    @Test()
    public void addTest(){
        arr.add(1);
        Assert.assertArrayEquals(arr.getArray(), new Integer[]{1});
    }

    @Test()
    public void addTest2(){
        arr.add(1);
        arr.add(5);
        arr.add(3);
        arr.add(-1);
        arr.add(0);
        arr.add(4);
        Assert.assertArrayEquals(arr.getArray(), new Integer[]{1, 5, 3, -1, 0, 4});
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
        arr.removeByIndex(3);
        Assert.assertArrayEquals(arr.getArray(), new Integer[]{1, 5, 3, 0, 4});
        Assert.assertEquals(arr.getSize(), 5);
    }

    @Test()
    public void removeTest(){
        arr.add(1);
        arr.add(5);
        arr.add(3);
        arr.add(-1);
        arr.add(0);
        arr.add(4);
        arr.remove(-1);
        Assert.assertArrayEquals(arr.getArray(), new Integer[]{1, 5, 3, 0, 4});
        Assert.assertEquals(arr.getSize(), 5);
    }

    @Test()
    public void insertTest(){
        arr.add(1);
        arr.add(5);
        arr.insert(1, 99);
        Assert.assertArrayEquals(arr.getArray(), new Integer[]{1, 99, 5});
    }

    @Test()
    public void containsTest(){
        arr.add(1);
        arr.add(5);
        arr.insert(1, 99);
        Assert.assertTrue(arr.contains(5));
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
