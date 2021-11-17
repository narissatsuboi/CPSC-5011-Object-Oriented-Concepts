/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

// CaesarCipher.h
// Specification file for the CaesarCipher class.


#ifndef HW6_CAESARCIPHER_H
#define HW6_CAESARCIPHER_H

#include <string>
using namespace std;

/**
 * CaesarCipher object can encrypt/decrypt a message by replacing each letter
 * in the message by a letter that is some fixed number of positions further
 * along in the alphabet (shift).
 *
 * Its encryption algorithm is to traverse the given string one character at
 * a time and for each character, transform the character by its shift number
 * of characters. For security reasons, the CaesarCipher object only stores
 * its shift, not the input or output strings.
 *
 * PER SLACK DIRECTION, ONLY SHIFT IS STORED IN THE CC. Follows Principle of
 * Single Responsibility.
 */
class CaesarCipher
{
public:

    /**
     * Constructor creates a CaesarCipher object, assigns value shift field.
     */
    CaesarCipher();

    /**
     * Copy constructor creates a deep copy of the given CaesarCipher object.
     */
    CaesarCipher(const CaesarCipher &);

    /**
     * Encrypts given string.
     * @return string, encrypted text.
     */
    string encrypt(const string&);

    /**
     * Decrypts given string.
     * @return string, decrypted text.
     */
    string decrypt(const string&);

    /**
     * Assignment operator
     * @return *this
     */
    CaesarCipher& operator = (const CaesarCipher &);

    /**
     * Addition operator creates a new CaesarCipher with a shift equal
     * to the shift of the operands, adjusted for minimum and maximum ranges.
     *
     * @return CaesarCipher, new cipher.
     */
    CaesarCipher operator + (const CaesarCipher &);

    /**
     * Equality operator checks the equality of the shift values of two
     * CaesarCipher objects.
     *
     * @return true, if shift fields are equal.
     */
    bool operator == (const CaesarCipher &) const;

    /**
     * Less than relational operator checks that the left operand CaesarCipher
     * object's shift field is less than that of the right.
     *
     * @return true, if left shift is LESS than the right.
     */
    bool operator < (const CaesarCipher &) const;

    /**
     * Greater than relational operator checks that the right operand
     * CaesarCipher object's shift field is less than that of the left.
     *
     * @return true, if right shift is GREATER than the left.
     */
    bool operator > (const CaesarCipher &) const;

    /**
     * Pre and post fix increment operators (for the shift field).
     * @return a pointer to this object
     */
    CaesarCipher& operator ++ ();   // prefix
    CaesarCipher operator ++ (int); // postfix

    static bool isSeeded;  // seed the random object once

private:
    int shift; // represents fixed # of positions along the alphabet
    const int OFFSET_MIN = 32; // ASCII range start "Space"
    const int OFFSET_MAX = 126; // ASCII range end "~"

    /**
     * Generates a random shift value.
     * @return shift
     */
    int getShift();

    /**
     *
     * @param string to be encrypted or decrypted
     * @param bool encrypt = true, decrypt = false
     * @return string, transformed
     */
    string encryptDecrypt(const string&, bool);

    /**
     * Checks that characters in string are within the ASCII character range
     * stored in the CaesarCipher fields.
     *
     * @param int, ASCII character decimal value
     * @return true, if ASCII character decimal value in range
     */
    bool isPositionInRange(int) const;
};

#endif //HW6_CAESARCIPHER_H
