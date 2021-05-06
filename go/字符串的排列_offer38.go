package main

func permutation(s string) []string {
	ans := make([]string, 0)

	iterate(s, &ans, 0)
	return nil
}

func iterate(s string, i *[]string, start int) {
	
}

func main() {
	permutation("123123")
}
