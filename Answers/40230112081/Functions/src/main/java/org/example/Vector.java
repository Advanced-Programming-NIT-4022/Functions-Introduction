package org.example;

public class Vector { // vector of String
    private int size;
    private String[] arr;

    public Vector(){
        size = 0;
        arr = new String[size];
    }
    public  void push(String item){
        if(size == 0)
        {
            size++;
            arr = new String[size];
            arr[size-1] = item;
        }
        else
        {
            String[] temp = new String[size];
            for(int i = 0;i < size;i++)
            {
                temp[i] = arr[i];
            }
            size++;
            arr = new String[size];
            for(int i = 0;i < size - 1;i++)
            {
                arr[i] = temp[i];
            }
            arr[size - 1] = item;
        }
    }

    public int capacity()
    {
        return size;
    }

    public void print()
    {
        for(int i = 0;i < size;i++)
        {
            System.out.println(arr[i]);
        }
    }

    public String[] get_arr()
    {
        return arr;
    }

    public String elementAt(int index){
        if(size <= index)
            return "Index out of range";
        return arr[index];
    }
}
