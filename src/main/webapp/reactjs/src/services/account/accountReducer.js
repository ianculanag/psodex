import * as AT from './accountTypes';

const initialState = {
    account: '',
    error: ''
};

const reducer = (state = initialState, action) => {
    switch(action.type) {
        case AT.SAVE_ACCOUNT_REQUEST:
        case AT.FETCH_ACCOUNT_REQUEST:
        case AT.UPDATE_ACCOUNT_REQUEST:
        case AT.DELETE_ACCOUNT_REQUEST:
            return {
                ...state
            };
        case AT.ACCOUNT_SUCCESS:
            return {
                account: action.payload,
                error: ''
            };
        case AT.ACCOUNT_FAILURE:
            return {
                account: [],
                error: action.payload
            }
        default:
            return state;
    }
};

export default reducer;