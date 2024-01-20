package com.Entities;

import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.Scalars;

public class GraphQLSchemaProvider {

    public GraphQLSchema getSchema() {
        // Define your GraphQL schema here
        return GraphQLSchema.newSchema()
                .query(buildRootQuery())
                .build();
    }

    private GraphQLObjectType buildRootQuery() {
        return GraphQLObjectType.newObject()
                .name("Query")
                .field(field -> field.name("hello")
                        .type(Scalars.GraphQLString)
                        .dataFetcher(environment -> "Hello, GraphQL!"))
                // Add other fields as needed
                .field(field -> field.name("myEntity")
                        .type(buildMyEntityType())
                        .dataFetcher(environment -> {
                            // Implement logic to retrieve MyEntity
                            MyEntity myEntity = new MyEntity();
                            myEntity.setId(1L);
                            myEntity.setName("Example");
                            return myEntity;
                        }))
                .build();
    }

    private GraphQLObjectType buildMyEntityType() {
        return GraphQLObjectType.newObject()
                .name("MyEntity")
                .field(field -> field.name("id").type(Scalars.GraphQLString))  // Use Scalars.GraphQLString for Long
                .field(field -> field.name("name").type(Scalars.GraphQLString))
                .build();
    }
}
