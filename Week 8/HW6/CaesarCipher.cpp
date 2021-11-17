/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

// CaesarCipher.cpp
// Implementation file for the CaesarCipher class.

#ifndef HW6_CAESARCIPHER
#define HW6_CAESARCIPHER

#include "CaesarCipher.h"
#include <ctime>         // for srand()
#include <stdexcept>
#include <iostream>



// *** Public *** //

bool CaesarCipher::isSeeded = false;

// Constructor
CaesarCipher::CaesarCipher() {
    this->shift = getShift();
}

// Copy constructor
CaesarCipher::CaesarCipher(const CaesarCipher& copy) {
    this->shift = copy.shift;
}

//encrypt
string CaesarCipher::encrypt(const string& s) {
    return encryptDecrypt(s, true);
}

//decrypt
string CaesarCipher::decrypt(const string& s) {
    return encryptDecrypt(s, false);
}

// Assignment operator
CaesarCipher &CaesarCipher::operator=(const CaesarCipher& right) {
    if (this != &right)
        this->shift = right.shift;
    return *this;
}

// Binary addition operator
CaesarCipher CaesarCipher::operator+(const CaesarCipher& right) {
    CaesarCipher temp;
    this->shift += right.shift;
    return temp;
}

// Equality operator
bool CaesarCipher::operator==(const CaesarCipher& other) const {
    return this->shift == other.shift;
}

// Less than operator
bool CaesarCipher::operator<(const CaesarCipher& other) const {
    return this->shift < other.shift;
}

// Greater than operator
bool CaesarCipher::operator>(const CaesarCipher& other) const {
    return this->shift > other.shift;
}

// Pre fix operator
CaesarCipher &CaesarCipher::operator++() {
    this->shift++;
    return *this;
}

// Post fix operator
CaesarCipher CaesarCipher::operator++(int) {
    CaesarCipher temp = *this;
    ++temp.shift;
    return temp;
}

// *** Private *** //

//getShift
int CaesarCipher::getShift() {
    // Check if random function had been seeded already, if not,
    // seed the random number generator
    if (!isSeeded) {
        srand(time(nullptr));
        isSeeded = true;
    }
    // Generate and return random shift value
    return (rand() % (OFFSET_MAX - OFFSET_MIN + 1)) + OFFSET_MIN;
}

//encryptDecrypt
string CaesarCipher::encryptDecrypt(const string& s, bool encrypt) {
    string result;                                  // Holds transformed string
    for (unsigned char ch: s) {
        int idx = ch, chpos;

        if (encrypt) {
            // Check character in range
            if (!isPositionInRange(int(ch))) {
                throw invalid_argument("String to be encrypted has "
                                       "unrecognized character " + string(1, ch));
            }
            chpos = idx + this->shift;
            if (chpos > OFFSET_MAX)
                chpos = OFFSET_MIN + (chpos - OFFSET_MAX);
        } else { // decrypt
            chpos = idx - this->shift;
            if (chpos < OFFSET_MIN)
                chpos = OFFSET_MAX - (OFFSET_MIN - chpos);
        }
        result += char(chpos);
        cout << chpos << " ";
    }
    cout << result << endl;
    return result;
}

//isPositionInRange
bool CaesarCipher::isPositionInRange(int idx) const {
    return idx >= OFFSET_MIN && idx <= OFFSET_MAX;
}


#endif //HW6_CAESARCIPHER
