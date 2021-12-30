import {SAVE_ACCOUNT_REQUEST, SAVE_ACCOUNT_SUCCESS, SAVE_ACCOUNT_FAILURE} from './accountTypes';

const initialState = {
    account: '',
    error: ''
};

const reducer = (state = initialState, action) => {
    switch(action.type) {
        case SAVE_ACCOUNT_REQUEST:
            return {
                ...state
            };
        case SAVE_ACCOUNT_SUCCESS:
            return {
                account: action.payload,
                error: ''
            };
        case SAVE_ACCOUNT_FAILURE:
            return {
                account: [],
                error: action.payload
            }
        default:
            return state;
    }
};

export default reducer;