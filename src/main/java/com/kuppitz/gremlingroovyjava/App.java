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
        Map eigenvactorRank = GraphAlgorithms.eigenvectorRank(g);
        System.out.println(eigenvactorRank);
    }
}
