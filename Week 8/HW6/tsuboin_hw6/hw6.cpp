#include <iostream>

// This program demonstrates the CaesarCipher class'
// Big 4 operations and overloaded operators
#include "CaesarCipher.h"
#include <string>
#include <iostream>
#include <iomanip>
#include <algorithm>
#include <vector>

using namespace std;



///**
// * Test helper function checks whether the string contains characters between
// * the
// * programs min and maximum offsets. Min and max are internally defined.
// * @param s
// * @return True if all characters within min and max.
// */
//bool inRange(const string& s) {
//    const int OFFSET_MIN = 32; // ASCII range start "Space"
//    const int OFFSET_MAX = 126; // ASCII range end "~"
//    auto isInRange = [](char i) { return (i >= char(OFFSET_MIN) && i <= char
//                                  (OFFSET_MAX)); };
//
//    if (all_of(s.begin(), s.end(), isInRange))
//        return true;
//    return false;
//}
//
//void testRange(const string& s) {
//    if (!inRange(s))
//        throw range_error(s + " OUT OF RANGE\n");
//}

int main() {


    cout << "***** RUN 3: *****\n\n";

    CaesarCipher cc; // test constructor
    string encryptedWord = cc.encrypt("Hello, world!");
    cout << "test constructor : cc" << endl;
    cout << "Encrypted: " << encryptedWord << endl;
    string decryptedWord = cc.decrypt(encryptedWord);
    cout << "Decrypted: " << decryptedWord << endl << endl;

    CaesarCipher cc2; // test constructor
    string encryptedWord2 = cc2.encrypt("Hello, world!");
    cout << "test constructor : cc2" << endl;
    cout << "Encrypted: " << encryptedWord2 << endl;
    string decryptedWord2 = cc2.decrypt(encryptedWord);
    cout << "Decrypted: " << decryptedWord2 << endl << endl;

    cout << "*** testing copy constructor and overloaded assignment ***\n\n";

    CaesarCipher cc3(cc2); // test copy constructor
    string encryptedWord3 = cc3.encrypt("Hello, world!");
    cout << "test copy constructor: cc3(cc2)" << endl;
    cout << "Encrypted: " << encryptedWord3 << endl;
    string decryptedWord3 = cc3.decrypt(encryptedWord);
    cout << "Decrypted: " << decryptedWord3 << endl << endl;


    cc2.operator=(cc); // test overloaded assignment operator
    encryptedWord2 = cc2.encrypt("Hello, world!");
    cout << "test overloaded assignment operator: cc2 = cc" << endl;
    cout << "Encrypted: " << encryptedWord2 << endl;
    decryptedWord2 = cc2.decrypt(encryptedWord);
    cout << "Decrypted: " << decryptedWord2 << endl << endl;


    cout << "*** printing cc, cc2, and cc3 ***\n\n";

    cout << "test constructor : cc" << endl;
    cout << "Encrypted: " << encryptedWord << endl;
    cout << "Decrypted: " << decryptedWord << endl << endl;

    cout << "test constructor : cc2" << endl;
    cout << "Encrypted: " << encryptedWord2 << endl;
    cout << "Decrypted: " << decryptedWord2 << endl << endl;

    cout << "test constructor : cc3" << endl;
    cout << "Encrypted: " << encryptedWord3 << endl;
    cout << "Decrypted: " << decryptedWord3 << endl << endl;

    cout << "*** testing comparators ***\n\n";

    cout << boolalpha << "cc == cc3 is " << cc.operator==(cc3) << endl;
    cout << boolalpha << "cc < cc3 is " << cc.operator<(cc3) << endl;
    cout << boolalpha << "cc > cc3 is " << cc.operator>(cc3) << endl << endl;

    cout << "*** testing add ***\n\n";
    cout << "test add : cc2 = cc + cc3\n";
    cc2 = cc.operator+(cc3);
    encryptedWord2 = cc2.encrypt("Hello, world!");
    cout << "Encrypted: " << encryptedWord2 << endl;
    cout << "Decrypted: " << decryptedWord2 << endl << endl;

    cout << "*** testing increment ***\n\n";

    cout << "test increment (postfix) : cc4 = cc++\n";
    CaesarCipher cc4;
    cc4.operator=(cc.operator++(0));
    string encryptedWord4 = cc4.encrypt("Hello, world!");
    cout << "Encrypted: " << encryptedWord4 << endl;
    string decryptedWord4 = cc4.decrypt(encryptedWord);
    cout << "Decrypted: " << decryptedWord4 << endl << endl;

    cout << "result of cc4 after postfix : \n";
    cc4.operator++();
    encryptedWord4 = cc4.encrypt("Hello, world!");
    cout << "Encrypted: " << encryptedWord4 << endl;
    decryptedWord4 = cc4.decrypt(encryptedWord);
    cout << "Decrypted: " << decryptedWord4 << endl << endl;

    cout << "test increment (prefix) : cc4 = ++cc\n";
    cc4.operator=(cc.operator++());
    encryptedWord4 = cc4.encrypt("Hello, world!");
    cout << "Encrypted: " << encryptedWord4 << endl;
    decryptedWord4 = cc4.decrypt(encryptedWord);
    cout << "Decrypted: " << decryptedWord4 << endl << endl;

    cout << "result of cc4 after prefix :\n";
    cc4.operator++();
    encryptedWord4 = cc4.encrypt("Hello, world!");
    cout << "Encrypted: " << encryptedWord4 << endl;
    decryptedWord4 = cc4.decrypt(encryptedWord);
    cout << "Decrypted: " << decryptedWord4 << endl << endl;

    cout << "test increment (postfix) : cc4 = cc2++\n";
    cc4.operator=(cc2.operator++(0));
    encryptedWord4 = cc4.encrypt("Hello, world!");
    cout << "Encrypted: " << encryptedWord4 << endl;
    decryptedWord4 = cc4.decrypt(encryptedWord);
    cout << "Decrypted: " << decryptedWord4 << endl << endl;

    cout << "result of cc4 after postfix :\n";
    cc4.operator++();
    encryptedWord4 = cc4.encrypt("Hello, world!");
    cout << "Encrypted: " << encryptedWord4 << endl;
    decryptedWord4 = cc4.decrypt(encryptedWord);
    cout << "Decrypted: " << decryptedWord4 << endl << endl;

    cout << "test increment (prefix) : cc4 = ++cc2 :\n";
    cc4.operator=(cc2.operator++());
    encryptedWord4 = cc4.encrypt("Hello, world!");
    cout << "Encrypted: " << encryptedWord4 << endl;
    decryptedWord4 = cc4.decrypt(encryptedWord);
    cout << "Decrypted: " << decryptedWord4 << endl << endl;

    cout << "result of cc4 after prefix :\n";
    cc4.operator++();
    encryptedWord4 = cc4.encrypt("Hello, world!");
    cout << "Encrypted: " << encryptedWord4 << endl;
    decryptedWord4 = cc4.decrypt(encryptedWord);
    cout << "Decrypted: " << decryptedWord4 << endl << endl;

    cout << "test increment (postfix) : cc4 = cc3++\n";
    cc4.operator=(cc3.operator++(0));
    encryptedWord4 = cc3.encrypt("Hello, world!");
    cout << "Encrypted: " << encryptedWord4 << endl;
    decryptedWord4 = cc3.decrypt(encryptedWord);
    cout << "Decrypted: " << decryptedWord4 << endl << endl;

    cout << "result of cc4 after postfix :\n";
    cc4.operator++();
    encryptedWord4 = cc4.encrypt("Hello, world!");
    cout << "Encrypted: " << encryptedWord4 << endl;
    decryptedWord4 = cc4.decrypt(encryptedWord);
    cout << "Decrypted: " << decryptedWord4 << endl << endl;

    cout << "test increment (prefix) : cc4 = ++cc3\n";
    cc4.operator=(cc3.operator++());
    encryptedWord4 = cc3.encrypt("Hello, world!");
    cout << "Encrypted: " << encryptedWord4 << endl;
    decryptedWord4 = cc3.decrypt(encryptedWord);
    cout << "Decrypted: " << decryptedWord4 << endl << endl;

    cout << "result of cc4 after prefix :\n";
    cc4.operator++();
    encryptedWord4 = cc4.encrypt("Hello, world!");
    cout << "Encrypted: " << encryptedWord4 << endl;
    decryptedWord4 = cc4.decrypt(encryptedWord);
    cout << "Decrypted: " << decryptedWord4 << endl << endl;

    cout << "*** testing list***\n\n";
    vector<CaesarCipher> v = {cc, cc2, cc3};
    cout << "test list : add cc, cc2, cc3\n\n";
    for (size_t i = 0; i < v.size(); i++) {
        cout << "test print list[" << i + 1 << "]\n";
        encryptedWord = v[i].encrypt("Hello, world!");
        cout << "Encrypted: " << encryptedWord << endl;
        decryptedWord = v[i].decrypt(encryptedWord);
        cout << "Decrypted: " << decryptedWord << endl << endl;

    }
}