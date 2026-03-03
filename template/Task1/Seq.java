public class Seq<T> {
  private T[] array;

  public Seq(int size) {
    // make changes where necessary
    this.array = new Object[size];
  }

  public void set(int index, T item) {
    this.array[index] = item;
  }

  public T get(int idx) {
    return this.array[idx];
  }
 
}
