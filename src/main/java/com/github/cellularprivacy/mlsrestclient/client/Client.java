package com.github.cellularprivacy.mlsrestclient.client;

import com.github.cellularprivacy.mlsrestclient.MlsRestClient;

abstract class Client<S> {
    protected MlsRestClient mlsRestClient;
    protected S service;

    public Client(MlsRestClient mlsRestClient, S service) {
        this.mlsRestClient = mlsRestClient;
        this.service = service;
    }
}
