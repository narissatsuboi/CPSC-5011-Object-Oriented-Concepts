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

// *** Public *** //

bool CaesarCipher::isSeeded = false;

// Constructor
CaesarCipher::CaesarCipher() {
    this->shift = getShift();
}

// Copy constructor
CaesarCipher::CaesarCipher(const CaesarCipher &copy) {
    this->shift = copy.shift;
}

//encrypt
string CaesarCipher::encrypt(const string &s) {
    return encryptDecrypt(s, true);
}

//decrypt
string CaesarCipher::decrypt(const string &s) {
    return encryptDecrypt(s, false);
}

// Assignment operator
CaesarCipher &CaesarCipher::operator=(const CaesarCipher &right) {
    if (this != &right)
        this->shift = right.shift;
    return *this;
}

// Binary addition operator
CaesarCipher CaesarCipher::operator+(const CaesarCipher &right) {
    CaesarCipher temp;
    this->shift += right.shift;
    return temp;
}

// Equality operator
bool CaesarCipher::operator==(const CaesarCipher &other) const {
    return this->shift == other.shift;
}

// Less than operator
bool CaesarCipher::operator<(const CaesarCipher &other) const {
    return this->shift < other.shift;
}

// Greater than operator
bool CaesarCipher::operator>(const CaesarCipher &other) const {
    return this->shift > other.shift;
}

// Pre fix operator
CaesarCipher &CaesarCipher::operator++() {
    this->shift++;
    if (this->shift == OFFSET_MAX)  // Adjust char position if 127
        this->shift = OFFSET_MIN;

    return *this;
}

// Post fix operator
CaesarCipher CaesarCipher::operator++(int) {
    CaesarCipher temp = *this;
    if (this->shift == OFFSET_MAX)  // Adjust char position if 127
        this->shift = OFFSET_MIN;
    else
        ++*this;
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
    return (rand() % (OFFSET_MAX - OFFSET_MIN + 1));
}

//encryptDecrypt
string CaesarCipher::encryptDecrypt(const string &s, bool encrypt) {
    string result;                                  // Holds transformed string
    for (char ch: s) {
        int idx = ch, chpos;

        // Check character in range
//        if (!isPositionInRange(idx)) {
//            throw invalid_argument("String to be encrypted has "
//                                   "unrecognized character " + string(1,idx));
//        }

        if (encrypt) {

            chpos = idx + this->shift;
            if (chpos > OFFSET_MAX) { // Adjust char position if 127+
                chpos = OFFSET_MIN + (chpos - OFFSET_MAX);
            }

        } else { // decrypt
            chpos = idx - this->shift;

            if (chpos < OFFSET_MIN) // Adjust char position if < 32
                chpos = OFFSET_MAX - (OFFSET_MIN - chpos);
        }
        result += char(chpos);
    }
    return result;
}

//isPositionInRange
bool CaesarCipher::isPositionInRange(int idx) const {
    return idx >= OFFSET_MIN && idx <= OFFSET_MAX;
}


#endif //HW6_CAESARCIPHER
