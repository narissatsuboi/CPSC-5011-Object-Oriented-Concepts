// List.h
// Specification file for the List class.
#ifndef LIST_H
#define LIST_H

#include <cassert>
template<typename T>
class List
{
public:
   List(int);           // Constructor
   ~List();             // Destructor
   List(const List<T>&);   // Copy constructor
   List<T>& operator=(const List<T>&);   // Overloaded assignment operator
   T& operator[](const int&);    // Overloaded [] operator
   void add(T);       // add element to array
   T get(int) const;  // returns element at given index
   int size();          // returns number of elements in array
private:
   T *list;           // pointer to the array
   int capacity;        // capacity of array
   int numElements;     // number of elements in array
   void resize();       // called to resize array when full
};
//#include "List.cpp" per textbook this should work, but it isn't needed
#endif
