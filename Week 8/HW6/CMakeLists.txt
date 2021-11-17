cmake_minimum_required(VERSION 3.17)
project(HW6)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++17 -W -Werror -Wall -pedantic")

add_executable(HW6 hw6.cpp CaesarCipher.cpp CaesarCipher.h)
