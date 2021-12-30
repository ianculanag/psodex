import {SAVE_ACCOUNT_REQUEST, FETCH_ACCOUNT_REQUEST, UPDATE_ACCOUNT_REQUEST, DELETE_ACCOUNT_REQUEST, ACCOUNT_SUCCESS, ACCOUNT_FAILURE} from './accountTypes';

const initialState = {
    account: '',
    error: ''
};

const reducer = (state = initialState, action) => {
    switch(action.type) {
        case SAVE_ACCOUNT_REQUEST || FETCH_ACCOUNT_REQUEST || UPDATE_ACCOUNT_REQUEST || DELETE_ACCOUNT_REQUEST:
            return {
                ...state
            };
        case ACCOUNT_SUCCESS:
            return {
                account: action.payload,
                error: ''
            };
        case ACCOUNT_FAILURE:
            return {
                account: [],
                error: action.payload
            }
        default:
            return state;
    }
};

export default reducer;