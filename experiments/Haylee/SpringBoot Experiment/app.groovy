@RestController
class ClassRunning {

    @GetMapping("/")
    String home() {
        return "Hello, World! \nand my 309 group \nfrom my Groovy app!"
    }
}

// groovy allows me to build spring mvc web apps with at least a single file