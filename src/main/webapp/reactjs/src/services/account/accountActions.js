import * as AT from './accountTypes';
import axios from 'axios';

export const saveAccount = account => {
    return dispatch => {
        dispatch({
            type: AT.SAVE_ACCOUNT_REQUEST
        });
        axios.post("http://localhost:3030/accounts", account)
            .then(response => {
                dispatch(accountSuccess(response.data));
            })
            .catch(error => {
                dispatch(accountFailure(error.message));
            });
    };
};

export const fetchAccount = accountId => {
    return dispatch => {
        dispatch({
            type: AT.FETCH_ACCOUNT_REQUEST
        });
        axios.get("http://localhost:3030/accounts/" + accountId)
            .then(response => {
                dispatch(accountSuccess(response.data));
            })
            .catch(error => {
                dispatch(accountFailure(error.message));
            });
    };
};

export const updateAccount = (accountId, account) => {
    return dispatch => {
        dispatch({
            type: AT.UPDATE_ACCOUNT_REQUEST
        });
        axios.put("http://localhost:3030/accounts/" + accountId, account)
            .then(response => {
                dispatch(accountSuccess(response.data));
            })
            .catch(error => {
                dispatch(accountFailure(error.message));
            });
    };
};

export const deleteAccount = accountId => {
    return dispatch => {
        dispatch({
            type: AT.DELETE_ACCOUNT_REQUEST
        });
        axios.delete("http://localhost:3030/accounts/" + accountId)
            .then(response => {
                dispatch(accountSuccess(response.data));
            })
            .catch(error => {
                dispatch(accountFailure(error.message));
            });
    };
};

const accountSuccess = accounts => {
    return {
        type: AT.ACCOUNT_SUCCESS,
        payload: accounts
    };
};

const accountFailure = error => {
    return {
        type: AT.ACCOUNT_FAILURE,
        payload: error
    };
};