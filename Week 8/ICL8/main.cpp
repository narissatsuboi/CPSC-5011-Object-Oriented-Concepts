#include <iostream>


// Base class
class Shape {
public:
    virtual double getArea() = 0;
    virtual double getPerimeter() = 0;
};

// Derived Rectangle class
class Rectangle : public Shape {
public:
    void setWidth(double w) {
        this->width = w;
    }

    void setLength(double l) {
        this->length = l;
    }

    double getArea() override {
        return width * length;
    }

    int getPerimeter() override {
        return (2*width) + (2*length);
    }

private:
    int width{};
    int length{};
};

// Derived class Triangle
class Triangle : public Shape {
public:
    void setHeight(double h) {
        this->height = h;
    }

    void setBase(int b) {
        this->base = b;
    }

    int getArea() override {
        return .5 ;
    }

    int getPerimeter() override {
        return (2*width) + (2*length);
    }
private:
    int base{};
    int height{};
};

/*
 * Demonstrate interface with Rectangle, Circle, and Triangle implementations.
 *
 */

int main() {
    std::cout << "Rectangle class w = 4, l = 5" << std::endl;
    Rectangle r;
    r.setWidth(4);
    r.setLength(5);
    std::cout << "Rectangle area... " << r.getArea();


    return 0;
}
