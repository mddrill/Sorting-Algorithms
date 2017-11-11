package com.company

class UtilsTest extends GroovyTestCase {

    void testAvg() {
        Integer[] arr = [3, 4, 7, 21, 9, 10, 2, 1, 6]
        assertEquals(7, (int)Utils.avg(arr))
    }

    void testCreateRandomIntegerArray() {
        Integer[] arr = Utils.createRandomIntegerArray(11)
        assertEquals(11, arr.length)
    }

    void testCopy() {
        Integer[] arr = [3, 4, 7, 21, 9, 6, 4, 2, 1, 6]
        Integer[] copyarr = Utils.copy(arr)
        assertArrayEquals(arr, copyarr)
        copyarr[1] = 18
        assertFalse(18 in arr)
    }
}
