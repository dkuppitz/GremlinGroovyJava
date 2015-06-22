package com.kuppitz.gremlingroovyjava

import com.tinkerpop.blueprints.impls.tg.TinkerGraph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory

/**
 *
 * @author Daniel Kuppitz <daniel at thinkaurelius.com>
 */
class GroovyApp {

    def run(final TinkerGraph g, final int loops) {
        def tg = System.currentTimeMillis()
        for (def i = 0; i < loops; i++) {
            g.eigenvectorRank()
        }
        tg = (System.currentTimeMillis() - tg)

        def groovyEigenvectorRank = g.eigenvectorRank()
        println "EXT:    " + groovyEigenvectorRank + " (" + tg + "ms for " + loops + " loops)"
    }
}
