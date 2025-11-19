// import { useQuery } from '@tanstack/react-query';
// import api from '@/lib/api';

// export interface Discipline {
//   id: number;
//   code: string;
//   name: string;
//   details: string;
//   isActive: boolean;
// }

// interface DisciplineResponse {
//   success: boolean;
//   data: Discipline[];
//   message: string;
// }

// /**
//  * Custom hook to fetch all active disciplines from the backend.
//  * 
//  * @returns Query result with disciplines data
//  */
// export const useDisciplines = () => {
//   return useQuery<Discipline[], Error>({
//     queryKey: ['disciplines'],
//     queryFn: async () => {
//       const response = await api.get<DisciplineResponse>('/disciplines');
      
//       if (response.data.success) {
//         return response.data.data;
//       } else {
//         throw new Error(response.data.message || 'Failed to fetch disciplines');
//       }
//     },
//     staleTime: 5 * 60 * 1000, // 5 minutes - disciplines don't change often
//     gcTime: 10 * 60 * 1000, // 10 minutes (formerly cacheTime in v4)
//     retry: 2,
//   });
// };

// /**
//  * Custom hook to fetch all disciplines including inactive ones.
//  * 
//  * @returns Query result with all disciplines data
//  */
// export const useAllDisciplines = () => {
//   return useQuery<Discipline[], Error>({
//     queryKey: ['disciplines', 'all'],
//     queryFn: async () => {
//       const response = await api.get<DisciplineResponse>('/disciplines/all');
      
//       if (response.data.success) {
//         return response.data.data;
//       } else {
//         throw new Error(response.data.message || 'Failed to fetch all disciplines');
//       }
//     },
//     staleTime: 5 * 60 * 1000,
//     gcTime: 10 * 60 * 1000, // 10 minutes (formerly cacheTime in v4)
//     retry: 2,
//   });
// };
