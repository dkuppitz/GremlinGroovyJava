package com.kuppitz.gremlingroovyjava;

import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import java.util.Map;

/**
 * Using Gremlin through Groovy
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final TinkerGraph g = TinkerGraphFactory.createTinkerGraph();
        final int loops = 1000;
        
        final Map groovyEigenvectorRank = GroovyGraphAlgorithms.eigenvectorRank(g);
        final Map javaEigenvectorRank = JavaGraphAlgorithms.eigenvectorRank(g);
        
        long tg = System.currentTimeMillis();
        for (int i = 0; i < loops; i++) {
            GroovyGraphAlgorithms.eigenvectorRank(g);
        }
        tg = (System.currentTimeMillis() - tg);
        
        long tj = System.currentTimeMillis();
        for (int i = 0; i < loops; i++) {
            JavaGraphAlgorithms.eigenvectorRank(g);
        }
        tj = (System.currentTimeMillis() - tj);
        
        System.out.println("GROOVY: " + groovyEigenvectorRank + " (" + tg + "ms for " + loops + " loops)");
        System.out.println("JAVA:   " + javaEigenvectorRank + " (" + tj + "ms for " + loops + " loops)");
        
        // test extension method
        new GroovyApp().run(g, loops);
    }
}
