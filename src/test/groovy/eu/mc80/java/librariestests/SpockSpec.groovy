package eu.mc80.java.librariestests

import spock.lang.Specification


class SpockSpec extends Specification {
    def setupSpec() {}    // runs once -  before the first feature method
    def setup() {
        // explicit conditions
        assert [].isEmpty()
    }        // runs before every feature method
    def cleanup() {}      // runs after every feature method
    def cleanupSpec() {}  // runs once -  after the last feature method

    def "when, then"() {
        when:
        def sum = 1 + 1

        then:
        sum == 2
    }

    def "exception"() {
        when:
        [].get(0)

        then:
        thrown(IndexOutOfBoundsException)
    }

    def "no exception"() {
        given:
        def map = new HashMap()

        when:
        map.put(null, "elem")

        then:
        notThrown(NullPointerException)
    }

    def "expect"() {
        expect:
        Math.max(1, 2) == 2
    }

    def "cleanup block"() {
        given:
        def file = new File("temp.txt")
        file.createNewFile()

        cleanup:
        file?.delete()
    }

    def "helper method"() {
        when:
        def string = "A string to test"

        then:
        matchesSpec(string)
    }

    void matchesSpec(String s) {
        assert !s.isBlank()
        assert s.startsWith("A")
        assert s.endsWith("test")
        assert s.split(" ").size() == 4
    }

    def "with"() {
        when:
        def string = "A string to test"

        then:
        with(string) {
            !isBlank()
            startsWith("A")
            endsWith("test")
            split(" ") == ["A", "string", "to", "test"]
        }
    }
}