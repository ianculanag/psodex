import {FETCH_TRANSACTION_REQUEST, FETCH_TRANSACTION_SUCCESS, FETCH_TRANSACTION_FAILURE} from './transactionTypes';

const initialState = {
    transactions: [],
    error: ''
};

const reducer = (state = initialState, action) => {
    switch(action.type) {
        case FETCH_TRANSACTION_REQUEST:
            return {
                ...state
            };
        case FETCH_TRANSACTION_SUCCESS:
            return {
                transactions: action.payload,
                error: ''
            };
        case FETCH_TRANSACTION_FAILURE:
            return {
                transactions: [],
                error: action.payload
            }
        default:
            return state;
    }
};

export default reducer;