class WIEWIORs23694_3_2 {
    static void main(String[] args) {
        def pmap = [ Groovy: [ 'Asia', 'Jan' ],
                     Grails: [ 'Asia', 'Jan', 'Stefan', 'Mirek' ],
                     Java: [ 'Asia', 'Stefan', 'Mirek' ],
                     JEE: [ 'Slawek', 'Stefan', 'Janusz' ]
        ]

        def keys = pmap.keySet()
        keys.each { key ->
            def quantity = pmap.get(key).size()
            println "$key: $quantity"
        }

        def moreEmployeesThanTwo = pmap.findAll {
            it.value.size() > 2
        }
        println moreEmployeesThanTwo

        def names = []
        println pmap.values().each({
            names = (names + it).unique()
        })
        names.each { name ->
            def projects = pmap.findAll({ it.value.contains(name) }).collect { element -> element.key }
            println "$name: $projects"
        }
    }
}