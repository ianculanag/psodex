import {FETCH_TRANSACTION_REQUEST, FETCH_TRANSACTION_SUCCESS, FETCH_TRANSACTION_FAILURE} from './transactionTypes';
import axios from 'axios';

export const fetchTransactions = () => {
    return dispatch => {
        dispatch(fetchTransactionRequest());
        axios.get("http://localhost:3030/transactions")
            .then(response => {
                dispatch(fetchTransactionSuccess(response.data));
            })
            .catch(error => {
                dispatch(fetchTransactionFailure(error.message));
            });
    };
};

const fetchTransactionRequest = () => {
    return {
        type: FETCH_TRANSACTION_REQUEST
    };
};

const fetchTransactionSuccess = transactions => {
    return {
        type: FETCH_TRANSACTION_SUCCESS,
        payload: transactions
    };
};

const fetchTransactionFailure = error => {
    return {
        type: FETCH_TRANSACTION_FAILURE,
        payload: error
    };
};