package main

func addBinary(a string, b string) string {
	res := []byte{}
	carry := 0

	for i, j := len(a)-1, len(b)-1; i >= 0 || j >= 0; {
		curr := carry
		if i >= 0 && a[i] == '1' {
			curr += 1
		}
		if j >= 0 && b[j] == '1' {
			curr += 1
		}
		if curr == 0 {
			res = append(res, '0')
			carry = 0
		} else if curr == 1 {
			res = append(res, '1')
			carry = 0
		} else if curr == 2 {
			res = append(res, '0')
			carry = 1
		} else if curr == 3 {
			res = append(res, '1')
			carry = 1
		}
		i--
		j--
	}
	if carry == 1 {
		res = append(res, '1')
	}
	reverse := func(arr []byte) []byte {
		for i, j := 0, len(arr)-1; i < j; {
			arr[i], arr[j] = arr[j], arr[i]
			i++
			j--
		}
		return arr
	}
	return string(reverse(res))
}
