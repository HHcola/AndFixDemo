# Sets the minimum version of CMake required to build the native
# library. You should either keep the default value or only pass a
# value of 3.4.0 or lower.

add_library( # Sets the name of the library.
             andfix

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             # Associated headers in the same location as their source
             # file are automatically included.
             ${CMAKE_CURRENT_SOURCE_DIR}/andfix.cpp
             ${CMAKE_CURRENT_SOURCE_DIR}/art/art_method_replace.cpp
             ${CMAKE_CURRENT_SOURCE_DIR}/art/art_method_replace_4_4.cpp
             ${CMAKE_CURRENT_SOURCE_DIR}/art/art_method_replace_5_0.cpp
             ${CMAKE_CURRENT_SOURCE_DIR}/art/art_method_replace_5_1.cpp
             ${CMAKE_CURRENT_SOURCE_DIR}/art/art_method_replace_6_0.cpp
             ${CMAKE_CURRENT_SOURCE_DIR}/art/art_method_replace_7_0.cpp
             ${CMAKE_CURRENT_SOURCE_DIR}/dalvik/dalvik_method_replace.cpp
              )
find_library(log-lib log)
target_link_libraries(andfix ${log-lib})
# target_include_directories (andfix PUBLIC ../)
