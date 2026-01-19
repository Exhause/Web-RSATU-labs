import { api } from "./api";

export async function getVillagerById(id) {
  return await api.get(`/villagers/${id}`);
}

export async function createVillager(villager) {
  return await api.post("/villagers", villager);
}

export async function updateVillager(villager) {
  return await api.put("/villagers", villager);
}

export async function deleteVillagerById(id) {
  await api.delete(`/villagers/${id}`);
}

export async function addDealToVillager(villagerId, dealId) {
  await api.post(`/villagers/${villagerId}/deals/${dealId}`);
}

export async function removeDealFromVillager(villagerId, dealId) {
  await api.delete(`/villagers/${villagerId}/deals/${dealId}`);
}
