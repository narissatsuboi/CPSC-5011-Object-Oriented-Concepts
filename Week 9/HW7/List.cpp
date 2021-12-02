#include "List.h"

template<class T>
List<T>::List(int cap)
{
   // assign numElements and capacity (from obj) 
   numElements = 0;
   capacity = cap;

   // allocate memory based on capacity
   list = new T[cap];

   // assign all values to zero
   for (int i = 0; i < cap; i++)
      list[i] = 0;
}

template<class T>
List<T>::~List()
{
   // deallocate memory
   delete [] list;
}

template<class T>
List<T>::List(const List& obj)
{
   // assign numElements and capacity (from obj) 
   numElements = obj.numElements;
   capacity = obj.capacity;

   // allocate memory based on capacity
   list = new T[capacity];

   // copy over elements (from obj)
   for (int i = 0; i < numElements; i++)
      list[i] = obj.list[i];
}

template<class T>
List<T>& List<T>::operator=(const List<T>& obj)
{
   if (this != &obj) // only assign if this != &obj
   {
      // delete list
      delete [] list;

      // assign numElements and capacity (from obj)
      numElements = obj.numElements;
      capacity = obj.capacity;

      // allocate memory based on capacity
      list = new int[capacity];

      // copy over elements (from obj)
      for (T i = 0; i < numElements; i++)
         list[i] = obj.list[i];
   }
   return *this;
}

template<class T>
T& List<T>::operator[](const int& index)
{
   assert(index >= 0 && index < capacity);
   return list[index];
}

template<class T>
void List<T>::add(T el)
{
   // if the array is full, resize
   if (numElements >= capacity)
      resize();
   
   // the new element will be added whether
   // resize() is called or not!
   list[numElements] = el;
   numElements++;
}

template<class T>
T List<T>::get(int index) const
{
   assert(index >= 0 && index < capacity);
   return list[index]; 
}

template<class T>
void List<T>::resize()
{
   // update capacity
   capacity *= 2;

   // create new array based on updated capacity
   T * tempArr = new T[capacity];

   // copy old array values to new array
   int i = 0;
   for (; i < numElements; i++)
      tempArr[i] = list[i];
   for (; i < capacity; i++)
      tempArr[i] = 0;

   // delete old array
   delete [] list;

   // reassign old array to new array
   list = tempArr;

}

template<class T>
int List<T>::size()
{
   // return the current number of elements in array
   return numElements;
}