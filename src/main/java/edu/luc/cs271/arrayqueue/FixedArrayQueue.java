package edu.luc.cs271.arrayqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FixedArrayQueue<E> implements SimpleQueue<E> {

  private final int capacity;

  private int size;

  private int front;

  private int rear;

  private final E[] data;

  // TODO why do we need an explicit constructor?

  @SuppressWarnings("unchecked")
  public FixedArrayQueue(final int capacity) {
    this.capacity = capacity;
    this.data = (E[]) new Object[capacity];
    this.size = 0;
    this.front = 0;
    this.rear = capacity - 1;
  }

  @Override
  public boolean offer(final E obj) {
    // DONE
    int temp = this.front;
    
    while(this.data[temp] != null){
      temp = (temp+1)%capacity;
      if(temp == this.front) return false;
    }
    this.size++;
    this.data[temp] = obj;
    return true;
  }

  @Override
  public E peek() {
    // DONE
   
    return this.data[this.front];
  }

  @Override
  public E poll() {
    // DONE
    E result = this.data[this.front];
    this.data[this.front] = null;
    this.size--;
    this.front = (this.front+1)%capacity;
    this.rear = (this.rear +1)%capacity;
    return result;
  }

  @Override
  public boolean isEmpty() {
    // DONE
    if (this.data[this.front] == null) return true;
    return true;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public List<E> asList() {
    // TODO implement using an ArrayList preallocated with the right size
    ArrayList<E> list = new ArrayList<E>();
    int temp = this.front;
    while(this.data[temp] != null){
      list.add(this.data[temp]);
      temp=(temp+1)%capacity;
      if(temp == this.front) break;
    }
    return list;
  }
}
