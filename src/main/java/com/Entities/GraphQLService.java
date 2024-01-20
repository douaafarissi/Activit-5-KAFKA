package com.Entities;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.GraphQLFieldDefinition;
import graphql.Scalars;


public class GraphQLService {


        private final GraphQL graphQL;

        public GraphQLService(GraphQLSchema graphQLSchema) {
            this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
        }

        public Object executeQuery(String query) {
            return graphQL.executeQuery(query);
        }
    }

