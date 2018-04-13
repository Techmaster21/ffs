// TODO figure out a way to reduce duplicate code for things that have essentially the same URLs except for their base
export const ACCOUNT_BASE = '/api/account';
export const RECIPE_BASE = 'api/recipe';
export const UNIT_BASE = 'api/unit';
export const CUISINE_BASE = 'api/cuisine';
export const FOOD_BASE = 'api/food';
export const PANTRY_BASE = 'api/pantry';
export const USER_BASE = 'api/user';
export const FRIENDSHIP_BASE = 'api/friendship';
export const URI = {
  ACCOUNT: {
    SIGNUP: `${ACCOUNT_BASE}/signup`,
    LOGIN: `${ACCOUNT_BASE}/login`
  },
  RECIPE: {
    GET: `${RECIPE_BASE}/get`,
    GET_ALL: `${RECIPE_BASE}/getAll`,
    SAVE: `${RECIPE_BASE}/save`,
    DELETE: `${RECIPE_BASE}/delete`,
    GET_USERS: `${RECIPE_BASE}/getUsersRecipes`,
    GET_PUBLIC: `${RECIPE_BASE}/getPublicRecipes`
  },
  UNIT: {
    GET: `${UNIT_BASE}/get`,
    GET_ALL: `${UNIT_BASE}/getAll`,
    SAVE: `${UNIT_BASE}/save`,
    DELETE: `${UNIT_BASE}/delete`
  },
  CUISINE: {
    GET: `${CUISINE_BASE}/get`,
    GET_ALL: `${CUISINE_BASE}/getAll`,
    SAVE: `${CUISINE_BASE}/save`,
    DELETE: `${CUISINE_BASE}/delete`
  },
  FOOD: {
    GET: `${FOOD_BASE}/get`,
    GET_ALL: `${FOOD_BASE}/getAll`,
    SAVE: `${FOOD_BASE}/save`,
    DELETE: `${FOOD_BASE}/delete`,
    SEARCH_BY_NAME: `${FOOD_BASE}/searchByName`
  },
  PANTRY: {
    GET: `${PANTRY_BASE}/get`,
    GET_ALL: `${PANTRY_BASE}/getAll`,
    SAVE: `${PANTRY_BASE}/save`,
    DELETE: `${PANTRY_BASE}/delete`
  },
  USER: {
    SEARCH_BY_NAME: `${USER_BASE}/searchByName`,
  },
  FRIENDSHIP: {
    REQUEST_FRIEND: `${FRIENDSHIP_BASE}/requestFriend`,
    GET_FRIEND_REQUESTS: `${FRIENDSHIP_BASE}/getFriendRequests`,
    ACCEPT_REQUEST: `${FRIENDSHIP_BASE}/acceptFriendRequest`,
    GET_FRIENDS: `${FRIENDSHIP_BASE}/getFriends`,
    DECLINE_REQUEST: `${FRIENDSHIP_BASE}/declineFriendRequest`
  }
};
