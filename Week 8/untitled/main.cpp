#include <iostream>

class Animal() {
public:
    Animal(String name, int numLegs, String catchphrase) {
        this.name = name;
        this.numLegs = numLegs;
        this.catchphrase = catchphrase;
    }

    String getName() {
        return this.name;
    }

    virtual int numberOfLegs() {
        return this.numLegs;
    }

    virtual void speak() {
        cout << catchphrase << endl;
    }

private:
    String name;
    int numLegs;
    String catchphrase;
}

class Human :: public Animal {

    virtual int numberOfLegs() {
        return Animal::numberOfLegs();
    }

    virtual String speak() {
        Animal::speak();
    }
};

class Dog :: public Animal {

virtual int numberOfLegs() {
    return Animal::numberOfLegs();
}

virtual String speak() {
    Animal::speak();
}

class Cat :: public Animal {

virtual int numberOfLegs() {
    return Animal::numberOfLegs();
}

virtual String speak() {
    Animal::speak();
}

int main() {
    Human myHuman = new Human("Mr. Test Human");
    Dog myDog = new Dog("Mr. Test Dog");
    Cat myCat = new Cat("Mr. Test Cat");
    Vector<Animal> list = new Vector<>;
    list.push(myHuman);
    list.push(myDog);
    list.push(myCat);

    for (auto animal : list) {
        Animal currentAnimal = animal;
        cout << "My name is " + animal.getName << endl;
        cout << "Number of legs: " + animal.numberOfLegs() << endl;
        animal.speak;
    }
}
}
