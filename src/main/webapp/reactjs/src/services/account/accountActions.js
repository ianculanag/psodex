import {SAVE_ACCOUNT_REQUEST, FETCH_ACCOUNT_REQUEST, UPDATE_ACCOUNT_REQUEST, DELETE_ACCOUNT_REQUEST, ACCOUNT_SUCCESS, ACCOUNT_FAILURE} from './accountTypes';
import axios from 'axios';

export const saveAccount = account => {
    return dispatch => {
        dispatch(saveAccountRequest());
        axios.post("http://localhost:3030/accounts", account)
            .then(response => {
                dispatch(accountSuccess(response.data));
            })
            .catch(error => {
                dispatch(accountFailure(error.message));
            });
    };
};

const saveAccountRequest = () => {
    return {
        type: SAVE_ACCOUNT_REQUEST
    };
};

const fetchAccountRequest = () => {
    return {
        type: FETCH_ACCOUNT_REQUEST
    };
};

export const fetchAccount = accountId => {
    return dispatch => {
        dispatch(fetchAccountRequest());
        axios.get("http://localhost:3030/accounts/" + accountId)
            .then(response => {
                dispatch(accountSuccess(response.data));
            })
            .catch(error => {
                dispatch(accountFailure(error.message));
            });
    };
};

const updateAccountRequest = () => {
    return {
        type: UPDATE_ACCOUNT_REQUEST
    };
};

export const updateAccount = (accountId, account) => {
    return dispatch => {
        dispatch(updateAccountRequest());
        axios.put("http://localhost:3030/accounts/" + accountId, account)
            .then(response => {
                dispatch(accountSuccess(response.data));
            })
            .catch(error => {
                dispatch(accountFailure(error.message));
            });
    };
};

const deleteAccountRequest = () => {
    return {
        type: DELETE_ACCOUNT_REQUEST
    };
};

export const deleteAccount = accountId => {
    return dispatch => {
        dispatch(deleteAccountRequest());
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
        type: ACCOUNT_SUCCESS,
        payload: accounts
    };
};

const accountFailure = error => {
    return {
        type: ACCOUNT_FAILURE,
        payload: error
    };
};