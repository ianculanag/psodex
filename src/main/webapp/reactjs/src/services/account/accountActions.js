import {SAVE_ACCOUNT_REQUEST, SAVE_ACCOUNT_SUCCESS, SAVE_ACCOUNT_FAILURE} from './accountTypes';
import axios from 'axios';

export const saveAccount = account => {
    return dispatch => {
        dispatch(saveAccountRequest());
        axios.post("http://localhost:3030/accounts", account)
            .then(response => {
                dispatch(saveAccountSuccess(response.data));
            })
            .catch(error => {
                dispatch(saveAccountFailure(error.message));
            });
    };
};

const saveAccountRequest = () => {
    return {
        type: SAVE_ACCOUNT_REQUEST
    };
};

const saveAccountSuccess = accounts => {
    return {
        type: SAVE_ACCOUNT_SUCCESS,
        payload: accounts
    };
};

const saveAccountFailure = error => {
    return {
        type: SAVE_ACCOUNT_FAILURE,
        payload: error
    };
};