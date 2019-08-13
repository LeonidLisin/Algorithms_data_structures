public class AdvancedArray<E extends Object & Comparable<? super E>> implements Array<E> {

    private boolean isSorted;
    private int size, index;
    private E[] arr;

    AdvancedArray(){
        this(DEFAULT_SIZE);
    }

    AdvancedArray(int size){
        isSorted = false;
        index = 0;
        this.size = size;
        arr = (E[])new Object[size];
    }

    @Override
    public void add(E element) {
        checkFull();
        arr[index++] = element;
        isSorted = false;
    }

    @Override
    public boolean addByIndex(int index, E element) {
        boolean result = false;
        if (index < size){
            arr[index] = element;
            result =  true;
        }
        isSorted = false;
        return result;
    }

    @Override
    public void insert(int index, E element) {
        if (index <= this.index){
            this.index++;
            checkFull();
            System.arraycopy(arr, index, arr, index + 1, this.index - index);
            arr[index] = element;
            isSorted = false;
        }
    }

    @Override
    public boolean removeByIndex(int index) {
        boolean result = false;
        if (index < this.index){
            System.arraycopy(arr, index + 1, arr, index, this.index - index -1);
            arr[this.index--] = null;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(E element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(element)){
                removeByIndex(i);
                break;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E element){
        boolean result = false;

        if (isSorted){
            int low = 0, high = index-1, mid;
            while (low<=high) {
                mid = (low + high) / 2;
                if (arr[mid].compareTo(element) > 0)
                    high = mid-1;
                if (arr[mid].compareTo(element) < 0)
                    low = mid+1;
                if (arr[mid].equals(element)){
                    result = true;
                    break;
                }
            }
        }
        else {
            for (int i = 0; i< index; i++){
                if (arr[i].equals(element)){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public void sort (SortingMethod sm){
        switch (sm){
            case BUBBLE:
            {
                for (int i = 0; i < index; i++) {
                    for (int j = 0; j < index-1-i; j++) {
                        if(arr[j].compareTo(arr[j+1]) > 0){
                            swap(arr, j, j+1);
                        }
                    }
                }
                break;
            }
            case INSERT:
            {
                int minIndex;
                for (int i = 0; i < index ; i++) {
                    minIndex = i;
                    for (int j = i+1; j < index; j++) {
                        if(arr[minIndex].compareTo(arr[j]) > 0){
                            minIndex = j;
                        }
                    }
                    swap(arr, i, minIndex);
                }
                break;
            }
            case SELECT:
            {
                for (int i = 1; i < index ; i++) {
                    E temp = arr[i];
                    int in = i;
                    while (in>0 && arr[in-1].compareTo(temp) >= 0){
                        arr[in] = arr[in-1];
                        in--;
                    }
                    arr[in] = temp;
                }
                break;
            }
        }
        isSorted = true;
    }

    private void swap(E[] e, int i1, int i2){
        E temp = e[i1];
        e[i1] = e[i2];
        e[i2] = temp;
    }

    @Override
    public E[] getArray(){
        E[]m = (E[])(new Object[index]);
        System.arraycopy(arr, 0, m, 0, index);
        return m;
    }

    @Override
    public E get(int index) {
        return arr[index];
    }

    @Override
    public int getSize() {
        return index;
    }

    private void checkFull(){
        if (index==size){
            size*=2;
            E[] tempArr = (E[])new Object[size];
            System.arraycopy(arr, 0, tempArr, 0, arr.length);
            arr  = tempArr;
        }
    }
}
